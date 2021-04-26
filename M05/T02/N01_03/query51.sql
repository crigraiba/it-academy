USE dbsegundo;

SELECT
	MAX(SAL),
	SUM(COMM),
	COUNT(*)
FROM
	empleados;