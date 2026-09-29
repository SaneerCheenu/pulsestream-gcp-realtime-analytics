#!/usr/bin/env bash

export PROJECT_ID="$(gcloud config get-value project)"
export REGION_ID="us-central1"
export ZONE_ID="$REGION_ID-a"
export APP_EVENTS_TOPIC="web-events"
export VPC_NETWORK_NAME="analytics-network"
export REDIS_NAME="analytics-redis"
export TEMP_GCS_BUCKET="$(whoami)-dataflow-temp"
