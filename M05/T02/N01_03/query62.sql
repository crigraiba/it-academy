USE dbsegundo;

SELECT
	COUNT(*)
FROM
	empleados
WHERE
	COMM IS NOT NULL
	AND COMM != 0;