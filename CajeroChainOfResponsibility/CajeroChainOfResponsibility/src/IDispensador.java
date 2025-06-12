public interface IDispensador {
    /**
     * @param next 
     */
    void setNext(IDispensador next);

    /**
     * @param monto 
     */
    void dispensar(int monto);
}