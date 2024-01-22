package org.kulynych;

import org.kulynych.entity.Cow;

public interface DairyFarm {

    void giveBirth(String parentCowId, Cow child);

    void endLifeSpan(String cowId);

    void printFarmData();
}