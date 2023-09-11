# FIZZBUZZ

[![Build](https://github.com/j-bogart/fizzbuzz/actions/workflows/build.yml/badge.svg)](https://github.com/j-bogart/fizzbuzz/actions/workflows/build.yml) [![Tests](https://github.com/j-bogart/fizzbuzz/actions/workflows/test.yml/badge.svg)](https://github.com/j-bogart/fizzbuzz/actions/workflows/test.yml) [![Security Scan](https://github.com/j-bogart/fizzbuzz/actions/workflows/security.yml/badge.svg)](https://github.com/j-bogart/fizzbuzz/actions/workflows/security.yml)

--- 

## Coding Challenge

The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing all multiples of 3 by “fizz”, all multiples of 5 by “buzz”, and all multiples of 15 by “fizzbuzz”.

Your goal is to implement a web server that will expose a REST API endpoint that:
- Accepts five parameters : three integers `int1`, `int2` and `limit`, and two strings `str1` and `str2`.
- Returns a list of strings with numbers from 1 to limit, where: all multiples of `int1` are replaced by `str1`, all multiples of `int2` are replaced by `str2`, all multiples of `int1` and `int2` are replaced by `str1str2`.
- The output must look like this : `["1","2","fizz","4","buzz","fizz","7","8","fizz","buzz",...]`

Add a statistics endpoint allowing users to know what the most frequent request has been. This endpoint should:
- Accept no parameter
- Return the parameters corresponding to the most used request, as well as the number of hits for this request
- The output must look like this : `{"int1":3,"int2":5,"limit":150,"str1":"fizz","str2":"buzz","count":3}`

The server needs to be:
- Ready for production
- Easy to maintain by other developers
- Code must be in Kotlin (or Java) with Spring Boot

## Purpose

The algorithm is deliberately simple, as the emphasis is on creating a Production Readiness API. However, you are free
to add whatever you feel is necessary to make the api usable as it stands.

## Features

This is a simple API coded in Java with Spring Boot. It includes :

- This documentation
- Required endpoints
- Tested code
- Continuous Integration
    - Linter
    - Commit naming checker
    - Automated tests
    - Vulnerabilities scaning
    - Automated Release and Versioning
    - Building

The project is based on Clean Architecture and Clean Code.  
The commit naming is using [Conventional Commits](conventionalcommits.org/) specifications.

What is not included (*it can go far...*) :

- API authentication
- Incremental counting in database
- Environments configuration and deployment automation
- Load balancing, gateway, dockerisation and more
- Monitoring and alerting

## Demo

clone repository

```bash
git clone https://github.com/j-bogart/fizzbuzz.git
cd fizzbuzz
```

run application on `http://localhost:8080`

```bash
./mvnw spring-boot:run
```

## API Reference

#### Get all items

```http
  POST /fizzbuzz
```

Return a sequence of fizzbuzz with specified parameters.

| Parameter | Type      | Description                                                          |
|:----------|:----------|:---------------------------------------------------------------------|
| `int1`    | `integer` | **Required**. Fizz number. *Value must be equal or higher than 1*    |
| `int2`    | `integer` | **Required**. Buzz number. *Value must be equal or higher than 1*    |
| `limit`   | `integer` | **Required**. Sequence limit. *Value must be equal or higher than 1* |
| `str1`    | `string`  | **Required**. Fizz word.                                             |
| `str2`    | `string`  | **Required**. Buzz word.                                             |

| Reponse Status Code | Description                               |
|:-------------------:|:------------------------------------------|
|        `201`        | Created                                   |
|        `400`        | At least one parameter is `null`          |
|        `422`        | Value of `int1` or `int2` is lower than 1 |

#### Get item

```http
  GET /fizzbuzz
```

Return the most used request.

| Reponse Status Code | Description |
|:-------------------:|:------------|
|        `200`        | Ok          |

## License

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)


