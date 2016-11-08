#!/bin/sh
+cd "$(dirname "$0")"
+java -jar ./target/Blue4-PageMap.jar "$@";-cp "target\*;"lib\*"
\ No newline at end of file