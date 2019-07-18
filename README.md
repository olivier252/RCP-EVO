# RCP-EVO
# RCP-EVO
######################################
Don't forget to update your application.properties to access the database connection  . 
##########
RCP modification , run configuration with jersey dependency .

The apsidiscount application must run with the org.glassfish.jersey .

#################################################
You need to create a library of dependency from ipapi-client-template

1) right click on the ipapi project and run as maven built

2) in goal section put  "dependency:copy-dependencies" 

3) export in target/dependency in your ipapi main folder

How to ?

1 ) first create a new project : file >  new project >  other > plug in from existing   jar archives 

2) add External > select all your depency in  target/dependency in your ipapi main folder (OPEN) (NEXT)

3) 	project name = org.glassfish.jersey
	project version = 2.27
	(FINISH)

4) (OPEN PERSPECTIVE)

5) in your perspective of your RCP project go to META-INF and open MANIFEST.MF and in dependencies add org.glassfish.jersey

6) go to runtime , and add and selection all package , (OK) and ctrl +S

7) then run > run configuration > add required Plug-in >  aplly > run 

####################################

For the next lauche go on the little arrow next to the Green one ( for starting app) and found your latest run cfg
