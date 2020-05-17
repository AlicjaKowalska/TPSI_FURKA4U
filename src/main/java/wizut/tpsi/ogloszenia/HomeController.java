package wizut.tpsi.ogloszenia;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.services.OffersService;


@Controller
public class HomeController {
    @Autowired
    private OffersService offersService;
    
     @RequestMapping("/")
    public String home(Model model) throws SQLException {
        model.addAttribute("carmanufacturer",offersService.getCarManufacturer(2));
        model.addAttribute("carmodel",offersService.getModel(3));
        return "index";
    }
    
}
