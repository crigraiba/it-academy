USE dbsegundo;

SELECT
	*
FROM
	empleados
WHERE
	EMPNO IN(7844, 7900, 7521, 7782, 7934, 7678, 7369)
	AND EMPNO NOT IN(7902, 7839, 7499, 7878);