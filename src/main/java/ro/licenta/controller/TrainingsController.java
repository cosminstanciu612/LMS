package ro.licenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.licenta.dao.TrainingDAO;
import ro.licenta.domain.Training;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by cosminstanciu on 30/03/2017.
 */
@Controller
public class TrainingsController {

    @Autowired
    private TrainingDAO trainingDAO;

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'hh:mm", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping(value = "/trainings")
    public String getTrainings(Model model) {
        model.addAttribute("trainings", trainingDAO.getAll());
        model.addAttribute("trainingForm",new Training());
        return "trainings";
    }

    @PostMapping(value = "/training/add")
    public String saveTraining(@ModelAttribute("trainingForm") Training trainingForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //TODO: use logs to print the errors on console
        }
        trainingDAO.create(trainingForm);
        return "redirect:/trainings";

    }

    public TrainingDAO getTrainingDAO() {
        return trainingDAO;
    }

    public void setTrainingDAO(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }
}
