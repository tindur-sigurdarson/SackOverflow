package is.hi.hpv501.sack.SackOverflow.Wrappers.Responses;

import is.hi.hpv501.sack.SackOverflow.Entities.Teams;
import org.springframework.validation.ObjectError;

import java.util.List;

public class GetAllTeamsResponse extends GenericResponse {
    private List<Teams> teams;

    public GetAllTeamsResponse(List<Teams> teams) {
        this.teams = teams;
    }

    public GetAllTeamsResponse(List<Teams> teams, String message, List<ObjectError> errors) {
        super(message, errors);
        this.teams = teams;
    }

    public List<Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Teams> movies) {
        this.teams = movies;
    }

}
