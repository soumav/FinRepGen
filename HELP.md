# Getting Started

All End-Points:
---------------
1) Upload raw financial data:

	http://localhost:8080/finrepgen/uploadfindata 
	(parameters -- key:file , input: FinInfo.xml)

2) Fetch raw financial data:

	http://localhost:8080/finrepgen/getrawfininfo
	
3) Fetch company info:

	http://localhost:8080/finrepgen/getcompanyinfo?compid=PEPCO&userid=11111
	
4) Update user data:

	http://localhost:8080/finrepgen/updateuserdata
	(parameters -- key:file , input: UserInfo.xml)