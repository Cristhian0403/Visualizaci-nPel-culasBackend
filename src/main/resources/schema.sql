DROP TABLE IF EXISTS movie;

CREATE TABLE movie (
    movieid INT PRIMARY KEY AUTO_INCREMENT,          -- Campo de clave primaria único
    name VARCHAR(255) NOT NULL,                 -- Nombre del ítem, obligatorio (NOT NULL)
    image VARCHAR(255) DEFAULT NULL,      -- Imagen de cubierta, puede ser NULL
    description TEXT DEFAULT NULL,              -- Descripción del ítem, puede ser NULL
    score TINYINT DEFAULT 0,                    -- Puntaje entre 0 y 9, por defecto es 0
    status TINYINT DEFAULT 1 NOT NULL,          -- Estado numérico (1 = publicada, 2 = edicion, etc.), por defecto 1
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- Fecha de creación, por defecto la fecha actual
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Fecha de modificación, actualizada automáticamente
);