CREATE TABLE IF NOT EXISTS books(
	id serial PRIMARY KEY,
	title VARCHAR(255) NOT NULL UNIQUE,
	summary VARCHAR(500) NOT NULL,
	table_of_contents TEXT,
	price NUMERIC(10, 2) NOT NULL CHECK (price >= 20),
	num_pages INTEGER NOT NULL CHECK(num_pages >= 100),
	isbn TEXT NOT NULL UNIQUE,
	release_date TIMESTAMP,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,

	category_id INTEGER NOT NULL REFERENCES categories(id),
	author_id INTEGER NOT NULL REFERENCES authors(id)
);