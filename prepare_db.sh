#!/bin/bash
echo "[INFO] check if you installed postgres"
if ! type postgres > /dev/null;then
echo "[INFO] try to install postgres"
brew install postgresql
fi

echo "[INFO] try to start postgres"
if [ ! -f /usr/local/var/dododo/postmaster.pid ]
then
    if [ ! -f /usr/local/var/dododo/postgresql.conf ]
    then
        initdb -D /usr/local/var/dododo
    fi
	postgres -D /usr/local/var/dododo >/dev/null 2>&1 &
	sleep 4
fi

echo '[INFO] you can stop postgres use:kill -INT `head -1 /usr/local/var/dododo/postmaster.pid`'
echo "[INFO] create user dododo"
psql postgres -tAc "SELECT 1 FROM pg_roles WHERE rolname='dododo'" | grep -q 1 || createuser dododo
echo "[INFO] create database dododo owner dododo"
psql postgres -tAc "SELECT 1 FROM pg_database WHERE datname='dododo'" | grep -q 1 || createdb --owner=dododo dododo
echo "[INFO] done!"
