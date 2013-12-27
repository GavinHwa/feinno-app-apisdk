feinno-app-apisdk
=================

Open for all developers to integrate with some open platforms such as sina,kaixin,tencent,etc.

Contain a dependency on feinno-app-common which is used for connection to MySQL and doesn't offer on Git Hub and is not essential to this project users.
Can simply remove dependcy on feinno-app-common and code in some Emontion related Class--even these classes is not essential to others since they are using to transform thirdparty emotions to Fetion Emotions.

The other MUST EDIT before using is Configuration. It read $FEINNO_CONFIG_PATH/message.properties by default. Be aware about it.

If you don't know how to use, just look tests.
