USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE
	EMPNO NOT IN(
		SELECT
			DISTINCT MGR
		FROM
			empleados
		WHERE
			MGR IS NOT NULL
	);