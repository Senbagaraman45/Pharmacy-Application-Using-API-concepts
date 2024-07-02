package com.example.PharmacyManagement.service.imple;

import com.example.PharmacyManagement.dao.PurchaseDao;
import com.example.PharmacyManagement.entity.Purchase;
import com.example.PharmacyManagement.entity.Stock;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.repository.PurchaseRepository;
import com.example.PharmacyManagement.repository.StockRepository;
import com.example.PharmacyManagement.service.PurchaseService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseImpl implements PurchaseService {

    private StockRepository stockRepository;
    private PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseImpl(PurchaseRepository purchaseRepository, EntityManager entityManager, StockRepository stockRepository) {
        this.purchaseRepository = purchaseRepository;
        this.stockRepository = stockRepository;
    }

//    @Override
//    public Purchase addOrder(Purchase purchase) {
//        List<Stock> b= stockRepository.findByBranchId(purchase.getBranchId());
//        if(!b.isEmpty()){
//            int i;
//            boolean isMedicineFound=false;
//            for(i=0;i<b.size();i++){
//                if(b.get(i).getMedicine().equals(purchase.getMedicine())){
//                    isMedicineFound=true;
//                    break;
//                }
//                else{
//                    continue;
//                }
//            }
//            if(isMedicineFound){
//                if(purchase.getQty()<b.get(i).getQty()){
//                    double amount=b.get(i).getPrice()*purchase.getQty();
//                    purchase.setAmount(amount);
//                    Purchase order=PurchaseDao.add_purchase(purchase);
//                    purchaseRepository.save(order);
//
//                    int new_qty=b.get(i).getQty();
//                    new_qty=new_qty- purchase.getQty();
//                    b.get(i).setQty(new_qty);
//                    stockRepository.save(b.get(i));
//                    return order;
//                }else{
////                    System.out.println("Quantity Not Available is that branch");
//                    throw new ExceptionThrow("Medicine Not Available in that branch", HttpStatus.BAD_REQUEST);
//                }
//            }else{
////                System.out.println("Medicine Not Available in that branch");
//                throw new ExceptionThrow("Medicine Not Available in that branch", HttpStatus.BAD_REQUEST);
//            }
//        }else{
////            System.out.println("Branch Id not found");
//            throw new ExceptionThrow("Branch Id not found", HttpStatus.BAD_REQUEST);
//        }
//    }

    @Override
    public List<Purchase> findAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public List<Purchase> listPurchase() {
        return purchaseRepository.findAll();
    }

//    @Override
//    public void saveOrder(Purchase purchase) {
//        List<Stock> b= stockRepository.findByBranchId(purchase.getBranchId());
//        if(!b.isEmpty()){
//            int i;
//            boolean isMedicineFound=false;
//            for(i=0;i<b.size();i++){
//                if(b.get(i).getMedicine().equals(purchase.getMedicine())){
//                    isMedicineFound=true;
//                    break;
//                }
//                else{
//                    continue;
//                }
//            }
//            if(isMedicineFound){
//                if(purchase.getQty()<b.get(i).getQty()){
//                    double amount=b.get(i).getPrice()*purchase.getQty();
//                    purchase.setAmount(amount);
//                    Purchase order=PurchaseDao.add_purchase(purchase);
//                    purchaseRepository.save(order);
//
//                    int new_qty=b.get(i).getQty();
//                    new_qty=new_qty- purchase.getQty();
//                    b.get(i).setQty(new_qty);
//                    stockRepository.save(b.get(i));
//                    System.out.println("Order Successful");
//                }else{
//                    System.out.println("Quantity Not Available is that branch");
//                    throw new RuntimeException("Quantity Not Available is that branch");
//                }
//            }else{
//                System.out.println("Medicine Not Available in that branch");
//                throw new RuntimeException("Medicine Not Available in that branch");
//            }
//        }else{
//            System.out.println("Branch Id not found");
//            throw new RuntimeException("Branch Id not found");
//        }
//
//    }
    @Override
    public Purchase addOrder(Purchase purchase) {
        List<Stock> b = stockRepository.findByBranchId(purchase.getBranchId());
        if (!b.isEmpty()) {
            int i;
            boolean isMedicineFound = false;
            for (i = 0; i < b.size(); i++) {
                if (b.get(i).getMedicine().equals(purchase.getMedicine())) {
                    isMedicineFound = true;
                    break;
                }
            }
            if (isMedicineFound) {
                if (purchase.getQty() < b.get(i).getQty()) {
                    double amount = b.get(i).getPrice() * purchase.getQty();
                    purchase.setAmount(amount);
                    Purchase order = PurchaseDao.add_purchase(purchase);
                    purchaseRepository.save(order);

                    int new_qty = b.get(i).getQty();
                    new_qty = new_qty - purchase.getQty();
                    b.get(i).setQty(new_qty);
                    stockRepository.save(b.get(i));
                    return order;
                } else {
                    throw new ApiException("Quantity Not Available in that branch", HttpStatus.BAD_REQUEST);
                }
            } else {
                throw new ApiException("Medicine Not Available in that branch", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new ApiException("Branch Id not found", HttpStatus.BAD_REQUEST);
        }
    }
}