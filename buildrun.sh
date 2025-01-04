# Author: Jack Robbins
# Builder/Runner script for the entire system

read -p "Do you want to test build[b] or build and run[br]?: " BUILD_ONLY

#Wipe the whole thing
echo "Wiping the market binary & recompiling"
cd ./market
mvn clean
mvn package
cd ..


if [[ $BUILD_ONLY = "br" ]]; then
	gnome-terminal -- java -jar ./market/target/market.jar
fi
