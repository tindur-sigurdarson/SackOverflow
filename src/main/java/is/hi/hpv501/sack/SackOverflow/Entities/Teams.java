package is.hi.hpv501.sack.SackOverflow.Entities;

import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teams {
        private String name;
        private String deild;
        private int id;
        private int rank;
        private String record;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idd;
        public Teams(){}
        public Teams(String deild,int id, String name, int rank,String record) {
            this.deild=deild;
            this.id = id;
            this.name = name;
            this.rank = rank;
            this.record = record;
        }

        public String getDeild() {
            return deild;
        }

        public void setDeild(String deild) {
            this.deild = deild;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getRecord() {
            return record;
        }

        public void setRecord(String record) {
            this.record = record;
        }

    @Override
        public String toString() {
            return id +'\''+name+'\'' + rank+ '\''+ deild + record;
        }
    }
