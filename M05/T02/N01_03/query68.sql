USE dbsegundo;

SELECT
	JOB,
	COUNT(*)
FROM
	empleados
GROUP BY
	JOB
ORDER BY
	JOB;