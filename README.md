# MuleSmooksEDItoXML
#Convertiong EDI to XML using smooks and MULE ESB

Mule Demo for using - EDI-to-XML Project
--------------
Demo for converting EDI message to XML using Smooks and MULE ESB


This project 
------------
1.	Continuously checks for the heartbeat of the application 
2.	Reads the file from the zip folder
3.	Unzip the files
4.	Using smooks transformer converts from edi to xml
5.	Outbounds the file.


Mule components
---------
1.	DB mysql config[db parameterized-query]
2.	FileInbound
3.	Java Component
4.	FileOutbound
5.	Smooks transformer


To Run
-------
Run as mule server or deploy into the mule sever as Mule Deployable Archive war and copy into mule-standalone the directory of the mule-standalone/apps


Technologies
---------
- J2E
- MySQL
- Mule Anypointstudio
- Smooks
