USE dbsegundo;

SELECT
	DNAME
FROM
	departamentos
WHERE
	DNAME NOT IN('SALES', 'RESEARCH')
ORDER BY
	LOC;