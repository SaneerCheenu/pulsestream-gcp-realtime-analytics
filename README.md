# PulseStream: Real-Time Event & Transaction Analytics Engine on GCP

PulseStream is an event-driven, near real-time streaming data pipeline and analytics backend built on **Google Cloud Platform (GCP)** using **Java**, **Apache Beam (Cloud Dataflow)**, **Cloud Pub/Sub**, **Google Cloud Storage (GCS)**, **BigQuery**, **Redis (Cloud Memorystore)**, and **Spring Boot**.

## Architecture Overview

1. **Event Ingestion (Python & Cloud Pub/Sub):** High-velocity JSON event streams are published to a Cloud Pub/Sub topic to simulate real-time user and transaction telemetry.
2. **Stream Processing (Java & Cloud Dataflow / Apache Beam):** A serverless Apache Beam pipeline consumes the unbounded Pub/Sub stream, stages pipeline artifacts in Google Cloud Storage (GCS), and performs windowed aggregations.
3. **Cardinality & Velocity Estimation (HyperLogLog & Redis):** Utilizes windowed HyperLogLog (HLL) cardinality estimation in Dataflow to compute real-time metrics, persisting low-latency state in Redis (Cloud Memorystore) while streaming structured records into BigQuery for historical analysis.
4. **Operational Metrics Backend (Spring Boot & Jedis):** A Spring Boot microservice deployed inside a firewall-protected GCP VPC network queries Redis (scard, sinterstore) to serve live operational metrics to an interactive web dashboard.

## Tech Stack
* **Languages:** Java, Python, SQL, HTML/JavaScript
* **Frameworks:** Apache Beam SDK, Spring Boot, Jedis
* **Cloud & Data Platform (GCP):** Cloud Dataflow, Cloud Pub/Sub, BigQuery, Google Cloud Storage (GCS), Cloud Memorystore (Redis), GCP VPC

## Project Structure
* `src/main/java/` — Core Apache Beam / Cloud Dataflow streaming pipeline implementation in Java.
* `dashboard/` — Spring Boot backend microservice and web dashboard for querying real-time Redis metrics.
* `generator.py` — Asynchronous Python event publisher for simulating high-throughput Pub/Sub streams.
* `set_variables.sh` — Environment configuration script for GCP project, Pub/Sub subscription, and GCS staging buckets.

## Running the Pipeline

1. Configure your GCP environment variables in `set_variables.sh`:

    source set_variables.sh

2. Deploy the Cloud Dataflow streaming job:

    mvn compile exec:java -Dexec.mainClass=com.google.cloud.solutions.dataflow.redis.RealTimeAnalyticsPipeline

3. Start the Spring Boot metrics service:

    cd dashboard && mvn spring-boot:run

## Author
**Saneer Wadhwa** — [GitHub](https://github.com/SaneerCheenu) | [LinkedIn](https://www.linkedin.com/in/SaneerWadhwa)
