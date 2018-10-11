#make keystore PASSWORD=changeit

PASSWORD=changeit
KEYSTORE=cert/keystore.p12
URL=https://downloads.pwnedpasswords.com/passwords/pwned-passwords-ordered-by-count.7z
FILE_NAME=pwned-passwords-ordered-by-count.7z
DOCKER_TAG=eu.wojciechzurek/pwned-password-checker
DOCKER_VERSION=1.0.0

# CN = Common Name
# OU = Organization Unit
# O  = Organization Name
# L  = Locality Name
# ST = State Name
# C  = Country (2-letter Country Code)
# E  = Email
DNAME_CA='CN=wojciechzurek.eu CA,OU=wojciechzurek.eu,O=wojciechzurek.eu,L=Rzeszow,ST=Podkarpackie,C=PL'

keystore:
	# Generate a certificate authority (CA)
	keytool -genkeypair -alias tomcat -ext BC=ca:true \
	    -keyalg RSA -keysize 4096 -sigalg SHA512withRSA \
	    -validity 3650 -dname $(DNAME_CA) -storetype PKCS12 \
	    -keystore $(KEYSTORE) -storepass $(PASSWORD)

download-db:
	wget -P db/download $(URL)
	7z e db/download/$(FILE_NAME) -odb/download/

build-docker:
	./gradlew clean check assemble
	docker build -t $(DOCKER_TAG):$(DOCKER_VERSION) -t $(DOCKER_TAG):latest -f Dockerfile .