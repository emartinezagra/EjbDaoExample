package es.uem.aju.common.dao.base;

public enum Columns
{
	
    PERSON_NAME( "ID", "PERSON", null );
	
    /**
     * The column name.
     */
    private String columnName;

    /**
     * The table name of column.
     */
    private String tableName;

    /** The size. */
    private Integer size;


    /**
     * Private parameterized constructor.
     *
     * @param columnName
     *            the column name
     * @param tableName
     *            the table name
     * @param size
     *            the size
     */
    private Columns( final String columnName, final String tableName, final Integer size )
    {
        this.columnName = columnName;
        this.tableName = tableName;
        this.size = size;
    }


    /**
     * Return columnName attribute.
     *
     * @return columnName - Attribute returned
     */
    public String getColumnName()
    {
        return columnName;
    }


    /**
     * Return tableName attribute.
     *
     * @return tableName - Attribute returned
     */
    public String getTableName()
    {
        return tableName;
    }


    /**
     * Return size attribute.
     *
     * @return size - Attribute returned
     */
    public Integer getSize()
    {
        return size;
    }

}
