# Home music dataflow (WIP)

Contains Spring Batch tasks compiled in native mode with GraalVM, following a DDD code architecture.
These tasks are used to back up Spotify library data to Firebase Datastore and synchronize liked tracks to YouTube

## Quickstart

See [QUICKSTART.md](QUICKSTART.md) to launch a simple task to log top tracks for a Spotify User on your local
workstation

## Github actions and Google Cloud setup

The workflows push container images to Google Artifact Registry, no secrets are needed in the repo setup for
authentication.
Instead, a special Google service account has been created and delegated to Github. Github Actions is then allowed to
use
this service account only on this repo to push images.

More details on this are present on the README of the Terraform
scripts [home-music-infra](https://github.com/lam-bo-apps/home-music-infra).
They prepare the artifact registry, the service account and output in console the env variables used in the
[02-build.yml](.github/workflows/02-build.yml) workflow.

