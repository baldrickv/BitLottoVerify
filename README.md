BitLottoVerify
==============

A java program to find the BitLotto winner.
It displays the hashes for each ticket and how they were reached.  The output is sorted so the first entry is the winner.

DOES NOT CHECK TIME OF TRANSACTIONS.  SO IT WILL INCLUDE LATE TRANSACTIONS.

You can now include as many addresses as needed for all the pools at the end.

$ java -jar jar/BitLottoVerify.jar 000000000000024760c69c7b052ea94444c9f6073f18c072fc21a9dedd0ab44d 202328353921 1KciuzsCfP97FM9Vs9oTbEvqx7dEXPqUn2 1LtMfB5M2zEuwUqLnWSPkLpUEUXxKQmtvH 13Pr5CLujsERfaRKm64FpebvUH9KFSbAbs 17PympqQEXpPiqCeh7P5hmNFxqkS3gjG3Q

Mixer: 000000000000024760c69c7b052ea94444c9f6073f18c072fc21a9dedd0ab44d202328353921
Mixer hash: 654b3652126a36243557acae9a6f5715059f7e0bb0c940a165d2ab6214f49847
Draw address: 1KciuzsCfP97FM9Vs9oTbEvqx7dEXPqUn2
Transactions: 233 BTC: 198.48106738 tickets: 792
Draw address: 1LtMfB5M2zEuwUqLnWSPkLpUEUXxKQmtvH
Transactions: 1 BTC: 2.0 tickets: 8
Draw address: 13Pr5CLujsERfaRKm64FpebvUH9KFSbAbs
Transactions: 28 BTC: 17.46006738 tickets: 63
Draw address: 17PympqQEXpPiqCeh7P5hmNFxqkS3gjG3Q
Transactions: 33 BTC: 15.25 tickets: 61

002f0438: Transaction: e15984fff0e016c99592b072412238bc46a39e625cb028d5bcc314bc94f6e9e9 multi:1 sha256(sha256(tx+1)+mixer_hash)
0049fe4e: Transaction: e545cf69b9c06d75e996afb4e6d497bf2a1624b4906480eca8567818ea029774 multi:3 sha256(sha256(tx+3)+mixer_hash)
004e358b: Transaction: 666f31532d549d694659c03102000ce3729b89ccada08fe4ebab24d0a89af9dd multi:1 sha256(sha256(tx+1)+mixer_hash)
005e5811: Transaction: 70fac19426f7458b5342139b4cebc760485b0b3555bcc307c61704926e04d27b multi:68 sha256(sha256(tx+68)+mixer_hash)
005f48ca: Transaction: 1f29d0aec3414cdf34ddc3f0dfdcb6995f585312f1d7726f3e0b3ff3da4b6a41 multi:7 sha256(sha256(tx+7)+mixer_hash)
006a8e40: Transaction: 7b28dde03583e3316a93cf70264a00827b23a518d1c108de26674dde697c5e50 sha256(tx+mixer_hash)
00b3ce60: Transaction: fb8ee962d038d3e1d4e5c66db089dac88fb1f8f3a4f0e0e8f720d3a932562b9c multi:5 sha256(sha256(tx+5)+mixer_hash)
010c54de: Transaction: 592ad24ad9bc655dd3d04d080107188a9331dd5f87950b5e373dc382ceada98f multi:15 sha256(sha256(tx+15)+mixer_hash)
012764cf: Transaction: fe661f8d94f12793511404acdd305b7ba781e078b6e1a93d558a1c21470a175a multi:36 sha256(sha256(tx+36)+mixer_hash)
0138baf3: Transaction: f747508469f30c2573821e3da4c55e06139b6c33cb9071871e3724bdd345df05 multi:26 sha256(sha256(tx+26)+mixer_hash)
01655c4c: Transaction: cc7ffc1666ae56a9ccc7b8f92acbec381fe8bef50f451ea59788134a776fe40d multi:1 sha256(sha256(tx+1)+mixer_hash)
01878492: Transaction: d99e237ccb07176a7d957555425baa6fd173491d8e6137acf8ef02110785df1c sha256(tx+mixer_hash)
01c5dcb8: Transaction: 7050967221c213023db41bc5f384ea176d0f450cd5b03c5aab3f8e3b7d50012f multi:1 sha256(sha256(tx+1)+mixer_hash)

