#!/bin/sh

nohup python /app/postrun/00_init_job.py >postrun.log 2>&1 &

/app/sbin/run.sh
