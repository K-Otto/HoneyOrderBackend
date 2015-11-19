/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import java.util.Date;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;

/**
 *
 * @author Ancel
 */
public class TreatmentFactory {
    public static Treatment createTreatment(String dateAdmitted, String dateDischarged) {
        Treatment treatment = new Treatment
                .Builder(dateAdmitted)
                .dateDischarged(dateDischarged)
                .build();
        return treatment;
    }
}
