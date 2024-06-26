package com.ltp.globalsuperstore;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class SuperStoreController
{
    private List<Item> items = new ArrayList<Item>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id)
    {
        int index = getIndexFromId(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new Item() : items.get(index));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    /**
     * Post request
     * @param item stores an item object taken from the form submission
     * @return a redirect to the inventory method that will run all the process
     */
    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes)
    {
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if(index == Constants.NOT_FOUND)
        {
            items.add(item);
        }
        else if (within5Days(item.getDate(), items.get(index).getDate())){
            items.set(index,item);
        } else {
            status = Constants.FAILED_STATUS;
        }
        //Save flash attribute    status: sucess
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    /**
     * getIntory
     * @return a inventory HTML screen where all the data is store (inventory.HTML)
     */
    @GetMapping("/inventory")
    public String getInventory(Model model)
    {
        model.addAttribute("items", items);
        return "inventory";
    }

    public int getIndexFromId(String id)
    {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

}
