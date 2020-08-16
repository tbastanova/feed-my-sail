package ru.otus.feedmysail.service;

import ru.otus.feedmysail.model.Team;

import java.util.List;

public interface TeamService {

    Team findById(long id);

    List<Team> findByUserId(long userId);
}
