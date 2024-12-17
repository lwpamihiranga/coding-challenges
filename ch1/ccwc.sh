#!/bin/bash

set -e

(
  cd "$(dirname "$0")"
  mvn -B -q clean package
)

exec java -jar ./target/ccwc.jar "$@"
