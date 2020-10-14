# Burp Multiplayer

A Multiplayer Plugin for Burp. Sync's in-scope requests/responses, comments, and highlights in realtime.

![Demo](/.github/demo.gif?raw=true "Demo")


## Setup

Install extension, connect multiple instances to the same [RethinkDB](https://rethinkdb.com/) instance.

You can use `rethinkdb.sh` to start a locally running instance in a Docker container. You can use `ssh -L <local_port>:localhost:<driver_port> <ip_of_rethinkdb_server>` to access a remote RethinkDB instance using an SSH tunnel.

#### RethinkDB Security
 
 * https://rethinkdb.com/docs/security/
 
