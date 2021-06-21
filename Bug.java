public interface Bug
{
    default public void apply(Bug t){
        t.apply(this::apply);
    }
    abstract public void func(Bug t);
}
