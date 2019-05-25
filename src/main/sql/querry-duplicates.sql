SELECT [method_index].[methodsignature],[class_index].class_name, [method_index].size, [method_index].bodyhash
FROM [method_index]
Inner JOin [class_method_mapping] on [class_method_mapping].method_key= [method_index].primaryKey
INNER JOIN [class_index] on class_index.primaryKey=[class_method_mapping].class_key
where [bodyhash] in(
	select [bodyhash] as C from [byte-code-indexes].[dbo].[method_index]  
group by [bodyhash] having COUNT(*) >1 ) order by [bodyhash]