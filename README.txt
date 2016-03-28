To set up database for testing:
1. Create database with name "uw_kiosk"
		OR
   Change database name in src/java/kiosk/KioskDataBean.java to existing database name.

2. Run web/WEB-INF/dbsetup_tables.sql on the database from step 1.

3. Run web/WEB-INF/dbsetup_data.sql on the database from step 1.

4. Change username and password in src/java/kiosk/KioskDataBean.java to existing MySQL username/password.

4. Tables have been created and populated. Build the project and you're good to go!


Valid student IDs for exam schedule search: 1149030, 3060402