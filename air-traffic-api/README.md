
# Air Traffic API (Integrated Java Backend)

Domain preserved from your previous project (City, Airport, Passenger, Aircraft). DTOs + CRUD + validation + Flyway + Docker.

## Run
```
docker compose up --build
```

## API Docs
Once running, open `/swagger-ui.html`.

## Endpoints (examples)
- Cities: `POST /api/cities`, `GET /api/cities`, `GET /api/cities/{id}`, `PATCH /api/cities/{id}`, `DELETE /api/cities/{id}`
- Airports: `POST /api/airports` (with `cityId`), `GET /api/airports`, `GET /api/airports/{id}`, `PATCH /api/airports/{id}`, `DELETE /api/airports/{id}`
- Passengers & Aircraft: similar CRUD.
