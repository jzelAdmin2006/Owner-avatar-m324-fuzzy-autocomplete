# syntax = edrevo/dockerfile-plus:0.1

INCLUDE+ Dockerfile.base
COPY ./build/libs/app.jar .
