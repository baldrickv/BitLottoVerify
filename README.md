BitLottoVerify
==============

A java program to find the BitLotto winner.
It displays the hashes for each ticket and how they were reached.  The output is sorted so the first entry is the winner.

DOES NOT CHECK TIME OF TRANSACTIONS.  SO IT WILL INCLUDE LATE TRANSACTIONS.


$ java -jar jar/BitLottoVerify.jar 14avxyPW5PgA68kGkDkY1mCGPP8zqkywEx 000000000000042c91c9de46f802524ab1c2296923a72b55fac2d2c6fd7f4741 113538415240

Draw address: 14avxyPW5PgA68kGkDkY1mCGPP8zqkywEx
Mixer: 000000000000042c91c9de46f802524ab1c2296923a72b55fac2d2c6fd7f4741113538415240
Mixer hash: 1e3c407515124ef4c674f1f997342cb882063f013b19b95184511ef196985b70
Transactions: 527 BTC: 288.751 tickets: 1155

0023da9a: Transaction: 277a5da2a46b0ba9ddaa33fa374bd9acd4a0ea227badf5d3e3d14d9a05238c81 sha256(tx+mixer_hash)
00397274: Transaction: 71599cc9375aef02271486acce76dc7059af5e27919429aa3ee62c915bf613f0 multi:81 sha256(sha256(tx+81)+mixer_hash)
006fd30e: Transaction: 71599cc9375aef02271486acce76dc7059af5e27919429aa3ee62c915bf613f0 multi:74 sha256(sha256(tx+74)+mixer_hash)
0095fa50: Transaction: 0fe78f915237de55378fd59a225c1f3e1c3c40f32da770924a7bcab3b67d548a multi:2 sha256(sha256(tx+2)+mixer_hash)
00b6d9ba: Transaction: 296d34b48f099d83a500b58bc7d411c23a8fc36bc5bb64fa7a34c789b6a2565a multi:2 sha256(sha256(tx+2)+mixer_hash)
00c42aff: Transaction: c9604c6144f4c12d585891e9b507cf7781d36ae6fcf3ccf4aef198fae754ca36 sha256(tx+mixer_hash)
00cf0b5e: Transaction: a1ea664b8d1acc35adc92bb38066beeb60b18063dc04a7485cacff772d2e0779 sha256(tx+mixer_hash)
0109bdcf: Transaction: 298b67a5dde791e1f0753c22230a89e0b0459bbc091d0fc3fc172ea08a953cab multi:2 sha256(sha256(tx+2)+mixer_hash)


