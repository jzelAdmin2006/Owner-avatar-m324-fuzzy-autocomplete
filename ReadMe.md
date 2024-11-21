# M324 DevOps Programming Exercise

## How to run

```sh
docker build -f Dockerfile.standalone -t m324-fuzzy-autocomplete .
```

### With default class.json

```sh
docker run -it -p 8080:8080 m324-fuzzy-autocomplete
```

### With custom class.json

```sh
docker run -it -p 8080:8080 -v [Path to your custom JSON file (on Windows, usually only absolute paths work)]:/app/class.json m324-fuzzy-autocomplete
```

#### Example

```sh
docker run -it -p 8080:8080 -v C:\workspace\m324-fuzzy-autocomplete\class.json:/app/class.json m324-fuzzy-autocomplete
```

## How to use

```sh
curl --request GET http://localhost:8080/search/[query for searching by name]
```

### Example

```sh
curl --request GET http://localhost:8080/search/Naim
```
