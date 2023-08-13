# HelloMessage
:memo: Simple MOTD plugin

----
#### Features
* Provides MOTD for players entering the server
* Multilingual MOTDs can be provided depending on each player's locale
* Support [Adventure MiniMessage](https://docs.advntr.dev/minimessage/index.html) for MOTD
----

### Examples
```yml
# Default MOTD
default: <rainbow>This is Default Message of HelloMessage.</rainbow>

# MOTD for Languages
# Set use-client-lang=true in config.yml.
# Format: ISO3Lang_ISO3Country
eng_usa: <rainbow>Hello!</rainbow>
kor_kor: <rainbow>안녕하세요!</rainbow>
```

* `use-user-lang=false` : Default MOTD
![image](https://github.com/RukiMC/HelloMessage/assets/33383685/9d71fcff-f00a-4271-af45-dfc8ac5f02e7)
* `use-user-lang=true` : Different MOTDs for User's locale
![image](https://github.com/RukiMC/HelloMessage/assets/33383685/3b957773-7bd8-4b4d-a1fb-6bf6a5a4c1d7)
![image](https://github.com/RukiMC/HelloMessage/assets/33383685/0efc1f58-acbd-45d9-8f27-843cb4bb7f3c)

----

### Contribution
#### Localization
Add .yml file to the resources/lang folder, copy eng_usa.yml, and start translation

English and Korean are provided as basic languages, and **Korean is the original text**.

> NOTE: yml file name format is `ISO3 Language`_`ISO3 Country`.yml
> Please note [ISO 639-3](https://iso639-3.sil.org/code_tables/639/data)

#### Development
This plugin uses [Heartbeat Coroutines](https://github.com/monun/heartbeat-coroutines).

But specially the version I fixed bug. (https://github.com/monun/heartbeat-coroutines/pull/8)

**DO NOT REMOVE or CHANGE `lib/heartbeat-coroutines-0.0.6.jar`**
