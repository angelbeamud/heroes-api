CREATE TABLE IF NOT EXISTS hero (
    id SERIAL PRIMARY KEY,
    name TEXT,
    organization TEXT,
    active BOOLEAN
);