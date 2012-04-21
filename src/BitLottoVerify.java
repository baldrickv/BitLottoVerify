import java.util.Map;
import java.util.Scanner;
import java.net.URL;

import java.util.TreeMap;
import java.util.StringTokenizer;

import java.security.MessageDigest;
import java.math.BigInteger;

import org.json.JSONTokener;
import org.json.JSONObject;
import org.json.JSONArray;



public class BitLottoVerify
{
    public static final long TICKET_COST=25000000L;
    

    public static void main(String args[]) throws Exception
    {
        if (args.length != 3)
        {
            System.out.println("Args: addr blockhash megamillions");
            System.out.println("Example: 14avxyPW5PgA68kGkDkY1mCGPP8zqkywEx 000000000000042c91c9de46f802524ab1c2296923a72b55fac2d2c6fd7f4741 113538415240"); 
            System.exit(1);
        }

        String addr = args[0];
        String blockhash = args[1];
        String megamillions = args[2];

        String mixer = blockhash + megamillions;
        String mixer_hash=sha256(blockhash + megamillions);
        System.out.println("Draw address: " + addr);
        System.out.println("Mixer: " + mixer);
        System.out.println("Mixer hash: " + mixer_hash);

        Map<String, String> draw_map = getDrawTxSet(addr, mixer_hash);
        System.out.println("Total tickets: " + draw_map.size());
        for(Map.Entry<String, String> me : draw_map.entrySet())
        {
            System.out.println(me.getKey() + ": " + me.getValue());
        }

    }

    public static String getJsonUrl(String addr, int offset)
    {
        return "http://blockchain.info/address/" + addr + "?format=json&offset=" + offset;
    }

    /** 
     * Returns a map of TXID to amount for the given address
     */
    public static Map<String, Long> getPayments(String addr)
        throws Exception
    {
        Map<String, Long> map = new TreeMap<String, Long>();

        int offset=0;
        while(true)
        {
            int found = readTransactions(addr, offset, map);
            if (found ==0) break;
            offset+=found;
        }
        return map;


    }
    public static int readTransactions(String addr, int offset, Map<String, Long> map)
        throws Exception
    {
        URL u = new URL(getJsonUrl(addr, offset));


        JSONObject addr_obj = new JSONObject(new JSONTokener(u.openConnection().getInputStream()));
        
        JSONArray tx_array = addr_obj.getJSONArray("txs");
        
        int len = tx_array.length();

        for(int i=0; i<len; i++)
        {
            JSONObject tx_obj = tx_array.getJSONObject(i);
            String txid = tx_obj.getString("hash");
            JSONArray out_array = tx_obj.getJSONArray("out");
            long total_val = 0;
            
            for(int j=0; j<out_array.length(); j++)
            {
                JSONObject out_obj = out_array.getJSONObject(j);

                String to_addr = out_obj.getString("addr");
                long value = out_obj.getLong("value");
                if (to_addr.equals(addr))
                {
                    total_val += value;
                }

            }

            if (total_val > 0)
            {
                map.put(txid, total_val);
            }

        }
        return len;

       
    }

    public static Map<String,String> getDrawTxSet(String addr, String mixer_hash)
        throws Exception
    {
        Map<String, Long> tx_map = getPayments(addr);

        int transactions=0;
        int tickets=0;
        long total_value=0;
        
        TreeMap<String, String> final_map = new TreeMap<String, String>();

        for(Map.Entry<String, Long> me : tx_map.entrySet())
        {
            String txid = me.getKey();
            long amt = me.getValue();

            transactions++;
            total_value+=amt;
            int ticket_num=0;

            while(amt >= TICKET_COST)
            {
                StringBuilder explain=new StringBuilder();
                explain.append("Transaction: " + txid +" ");
                String ticket_str = txid;
                if (ticket_num >= 1)
                {
                    explain.append("multi:" + ticket_num + " sha256(sha256(tx+"+ticket_num+")+mixer_hash)");
                    String hash_str = txid + ticket_num;
                    ticket_str = sha256(hash_str);
                }
                else
                {
                    explain.append("sha256(tx+mixer_hash)");
                }
                String res = sha256(ticket_str + mixer_hash);

                final_map.put(res, explain.toString());

                amt -= TICKET_COST;
                ticket_num++;
                tickets++;


            }


        }

        double btc = total_value / 1e8;
        System.out.println("Transactions: " + transactions + " BTC: " + btc + " tickets: " + tickets );
        return final_map;


    }

    public static String sha256(String str)
    {
        try
        {
            byte[] buff = str.getBytes();

            MessageDigest sig=MessageDigest.getInstance("SHA-256");
            sig.update(buff, 0, buff.length);

            byte d[]=sig.digest();
            return printBytesInHex(d);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
            return null;
        }

    }
    public static String printBytesInHex(byte[] d)
    {
        StringBuffer s=new StringBuffer(d.length*2);
        BigInteger bi=new BigInteger(1,d);
        s.append(bi.toString(16));
        while(s.length() < d.length*2)
        {
            s.insert(0, '0');
        }
        return s.toString();

    }


}

