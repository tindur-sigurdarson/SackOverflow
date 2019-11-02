package is.hi.hpv501.sack.SackOverflow.Entities;

import org.json.JSONObject;

public class Teams {
        private String deild;
        private int id;
        private String name;
        private int rank;

        public Teams(){}
        public Teams(String deild,int id, String name, int rank) {
            this.deild=deild;
            this.id = id;
            this.name = name;
            this.rank = rank;
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

        @Override
        public String toString() {
            return "Teams{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", rank=" + rank +
                    ", deild=" + deild +
                    '}';
        }
    }
