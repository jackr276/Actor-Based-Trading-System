# Author: Jack Robbins
# Builder/Runner script for the entire system

read -p "Do you want to test build[b] or build and run[br]?: " BUILD_ONLY

#Wipe the whole thing
echo "Wiping the CTS binary & recompiling"
cd ./cts
mvn clean
mvn package
cd ..

echo "Wiping the webclient binary & recompiling"
cd ./cts-webclient
mvn clean
mvn package
cd ..



if [[ $BUILD_ONLY = "br" ]]; then
	gnome-terminal -- java -jar ./cts/target/JMR-Common-Transactive-Services.jar
	gnome-terminal -- java -jar ./cts-webclient/target/cts-webclient-0.0.1-SNAPSHOT.jar
fi
