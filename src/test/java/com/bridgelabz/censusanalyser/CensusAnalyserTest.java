package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    public static final String INDIAN_STATE_CENSUS_FILE = "src\\main\\resources\\IndianStateCensusData.csv";

    //UC-1
    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() {
        try {
            int count = CensusAnalyser.loadCensusData(INDIAN_STATE_CENSUS_FILE);
            Assert.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}