#!/bin/bash
server=qtest.mathcs.emory.edu

cd "$(dirname "$0")"
java -cp lib/qtest.jar:lib/rsyntaxtextarea-2.5.8.jar -Djava.security.policy=lib/client.policy QTest $server 1910 1080 >/dev/null 2>/dev/null

