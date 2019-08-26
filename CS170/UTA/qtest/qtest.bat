@echo off
java -cp lib/qtest.jar;lib/rsyntaxtextarea-2.5.8.jar -Djava.security.policy=lib/client.policy QTest qtest.mathcs.emory.edu 1910 1080 >nul 2>&1
