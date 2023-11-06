import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class XIAODING implements Comparable<XIAODING>{


    private String name;

    private Integer age;

    private Integer number;




    @Override
    public int compareTo(XIAODING o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age==o.age) {
            if(this.number > o.number){
                return 1;
            }else {
                return -1;
            }
        }else {
            return -1;
        }
    }
}
