# Author: Jack Robbins
# Builder/Runner script for the entire system

read -p "Do you want to test build[b] or build and run[br]?: " BUILD_ONLY

#Wipe the whole thing
echo "Wiping the CTS binary & recompiling"
cd ./market
mvn clean
mvn package
cd ..

echo "Wiping the webclient binary & recompiling"
cd ./actor_webclient
mvn clean
mvn package
cd ..



if [[ $BUILD_ONLY = "br" ]]; then
	gnome-terminal -- java -jar ./market/target/JMR-Common-Transactive-Services.jar
	gnome-terminal -- java -jar ./actor_webclient/target/actor-webclient-0.0.1-SNAPSHOT.jar
fi
