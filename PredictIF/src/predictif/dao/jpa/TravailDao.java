/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import predictif.metier.modele.Travail;

/**
 *
 * @author quentin
 */
public interface TravailDao {
    public void creerPredictionTravail(Travail travail);
}
