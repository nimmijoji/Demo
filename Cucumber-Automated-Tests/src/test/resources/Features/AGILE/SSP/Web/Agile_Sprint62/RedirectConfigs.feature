#Author: Soumen Maity

@SSP_Web_Sprint62 @dualLang
Feature: As a website user, I want to see the correct regional/language version of the website 
	when i enter the country code in lower case OR upper case in the URL structure.


  @SSP_921
  Scenario Outline: I enter the country code for "<store>" in lower case OR upper case in the URL structure, I should navigate to the "<page>"
    Given customer navigates to url "<URLs>"
    And customer accesses the website as "guest" user
    And I wait for "3" seconds
		Then customer open "<URLs>" and verify if that is converted to "<ExpectedURLs>" for "<page>" in "<store>" store
		
	@eu @homepage
	Examples:
		|	store	|	URLs																			|	ExpectedURLs															| page			|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-BE	|	https://www-be-ftprdeu.farnell.com/fr-BE	|	HomePage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-be	|	https://www-be-ftprdeu.farnell.com/fr-BE	|	HomePage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be	|	https://www-be-ftprdeu.farnell.com/fr-BE	|	HomePage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be	|	https://www-be-ftprdeu.farnell.com/fr-BE	|	HomePage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-CZ	|	https://www-cz-ftprdeu.farnell.com/en-CZ	|	HomePage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-cz	|	https://www-cz-ftprdeu.farnell.com/en-CZ	|	HomePage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/en-cz	|	https://www-cz-ftprdeu.farnell.com/en-CZ	|	HomePage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-DE	|	https://www-de-ftprdeu.farnell.com/en-DE	|	HomePage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-de	|	https://www-de-ftprdeu.farnell.com/en-DE	|	HomePage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/en-de	|	https://www-de-ftprdeu.farnell.com/en-DE	|	HomePage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-IT	|	https://www-it-ftprdeu.farnell.com/en-IT	|	HomePage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-it	|	https://www-it-ftprdeu.farnell.com/en-IT	|	HomePage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it	|	https://www-it-ftprdeu.farnell.com/en-IT	|	HomePage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-CH	|	https://www-ch-ftprdeu.farnell.com/fr-CH	|	HomePage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-ch	|	https://www-ch-ftprdeu.farnell.com/fr-CH	|	HomePage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch	|	https://www-ch-ftprdeu.farnell.com/fr-CH	|	HomePage	|
	@eu @BFP
	Examples:
		|	store	|	URLs																															|	ExpectedURLs																											| page			|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-BE/rechercher-des-produits	|	https://www-be-ftprdeu.farnell.com/fr-BE/rechercher-des-produits	|	BrowseForProduct	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-be/rechercher-des-produits	|	https://www-be-ftprdeu.farnell.com/fr-BE/rechercher-des-produits	|	BrowseForProduct	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be/rechercher-des-produits	|	https://www-be-ftprdeu.farnell.com/fr-BE/rechercher-des-produits	|	BrowseForProduct	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-CZ/browse-for-products	|	https://www-cz-ftprdeu.farnell.com/en-CZ/browse-for-products	|	BrowseForProduct	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-cz/browse-for-products	|	https://www-cz-ftprdeu.farnell.com/en-CZ/browse-for-products	|	BrowseForProduct	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/en-cz/browse-for-products	|	https://www-cz-ftprdeu.farnell.com/en-CZ/browse-for-products	|	BrowseForProduct	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-DE/browse-for-products	|	https://www-de-ftprdeu.farnell.com/en-DE/browse-for-products	|	BrowseForProduct	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-de/browse-for-products	|	https://www-de-ftprdeu.farnell.com/en-DE/browse-for-products	|	BrowseForProduct	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/en-de/browse-for-products	|	https://www-de-ftprdeu.farnell.com/en-DE/browse-for-products	|	BrowseForProduct	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-IT/browse-for-products	|	https://www-it-ftprdeu.farnell.com/en-IT/browse-for-products	|	BrowseForProduct	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-it/browse-for-products	|	https://www-it-ftprdeu.farnell.com/en-IT/browse-for-products	|	BrowseForProduct	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it/browse-for-products	|	https://www-it-ftprdeu.farnell.com/en-IT/browse-for-products	|	BrowseForProduct	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-CH/rechercher-des-produits	|	https://www-ch-ftprdeu.farnell.com/fr-CH/rechercher-des-produits	|	BrowseForProduct	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-ch/rechercher-des-produits	|	https://www-ch-ftprdeu.farnell.com/fr-CH/rechercher-des-produits	|	BrowseForProduct	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch/rechercher-des-produits	|	https://www-ch-ftprdeu.farnell.com/fr-CH/rechercher-des-produits	|	BrowseForProduct	|
	@eu @categorypage
	Examples:
		|	store	|	URLs																																														|	ExpectedURLs																																										| page					|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-BE/c/cables-fils-cables-assembles/accessoires-de-cablage	|	https://www-be-ftprdeu.farnell.com/fr-BE/c/cables-fils-cables-assembles/accessoires-de-cablage	|	CategoryPage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-be/c/cables-fils-cables-assembles/accessoires-de-cablage	|	https://www-be-ftprdeu.farnell.com/fr-BE/c/cables-fils-cables-assembles/accessoires-de-cablage	|	CategoryPage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be/c/cables-fils-cables-assembles/accessoires-de-cablage	|	https://www-be-ftprdeu.farnell.com/fr-BE/c/cables-fils-cables-assembles/accessoires-de-cablage	|	CategoryPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits	|	https://www-cz-ftprdeu.farnell.com/en-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits	|	CategoryPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-cz/c/development-boards-evaluation-tools/data-conversion-development-kits	|	https://www-cz-ftprdeu.farnell.com/en-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits	|	CategoryPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/en-cz/c/development-boards-evaluation-tools/data-conversion-development-kits	|	https://www-cz-ftprdeu.farnell.com/en-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits	|	CategoryPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-DE/c/passive-components/filters	|	https://www-de-ftprdeu.farnell.com/en-DE/c/passive-components/filters	|	CategoryPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-de/c/passive-components/filters	|	https://www-de-ftprdeu.farnell.com/en-DE/c/passive-components/filters	|	CategoryPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/en-de/c/passive-components/filters	|	https://www-de-ftprdeu.farnell.com/en-DE/c/passive-components/filters	|	CategoryPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-IT/c/development-boards-evaluation-tools/data-conversion-development-kits	|	https://www-it-ftprdeu.farnell.com/en-IT/c/development-boards-evaluation-tools/data-conversion-development-kits	|	CategoryPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-it/c/development-boards-evaluation-tools/data-conversion-development-kits	|	https://www-it-ftprdeu.farnell.com/en-IT/c/development-boards-evaluation-tools/data-conversion-development-kits	|	CategoryPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it/c/development-boards-evaluation-tools/data-conversion-development-kits	|	https://www-it-ftprdeu.farnell.com/en-IT/c/development-boards-evaluation-tools/data-conversion-development-kits	|	CategoryPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-CH/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	https://www-ch-ftprdeu.farnell.com/fr-CH/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	CategoryPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-ch/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	https://www-ch-ftprdeu.farnell.com/fr-CH/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	CategoryPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	https://www-ch-ftprdeu.farnell.com/fr-CH/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	CategoryPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	https://www-ch-ftprdeu.farnell.com/fr-CH/c/protections-electriques/fusibles-accessoires-pour-fusibles	|	CategoryPage	|
	@eu @PLP
	Examples:
		|	store	|	URLs																																																													|	ExpectedURLs																																																									| page|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-BE/c/cables-fils-cables-assembles/accessoires-de-cablage/bouchons-d-obturation-de-cable	|	https://www-be-ftprdeu.farnell.com/fr-BE/c/cables-fils-cables-assembles/accessoires-de-cablage/bouchons-d-obturation-de-cable	|	PLP	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-be/c/cables-fils-cables-assembles/accessoires-de-cablage/bouchons-d-obturation-de-cable	|	https://www-be-ftprdeu.farnell.com/fr-BE/c/cables-fils-cables-assembles/accessoires-de-cablage/bouchons-d-obturation-de-cable	|	PLP	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be/c/cables-fils-cables-assembles/accessoires-de-cablage/bouchons-d-obturation-de-cable	|	https://www-be-ftprdeu.farnell.com/fr-BE/c/cables-fils-cables-assembles/accessoires-de-cablage/bouchons-d-obturation-de-cable	|	PLP	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	https://www-cz-ftprdeu.farnell.com/en-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	PLP	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-cz/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	https://www-cz-ftprdeu.farnell.com/en-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	PLP	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/en-cz/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	https://www-cz-ftprdeu.farnell.com/en-CZ/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	PLP	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-DE/c/passive-components/filters/feedthrough-capacitors	|	https://www-de-ftprdeu.farnell.com/en-DE/c/passive-components/filters/feedthrough-capacitors	|	PLP	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-de/c/passive-components/filters/feedthrough-capacitors	|	https://www-de-ftprdeu.farnell.com/en-DE/c/passive-components/filters/feedthrough-capacitors	|	PLP	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/en-de/c/passive-components/filters/feedthrough-capacitors	|	https://www-de-ftprdeu.farnell.com/en-DE/c/passive-components/filters/feedthrough-capacitors	|	PLP	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-IT/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	https://www-it-ftprdeu.farnell.com/en-IT/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	PLP	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-it/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	https://www-it-ftprdeu.farnell.com/en-IT/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	PLP	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	https://www-it-ftprdeu.farnell.com/en-IT/c/development-boards-evaluation-tools/data-conversion-development-kits/data-conversion-development-kits-dac	|	PLP	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-CH/c/cables-fils-cables-assembles/cables-plats-cables-en-nappe	|	https://www-ch-ftprdeu.farnell.com/fr-CH/c/cables-fils-cables-assembles/cables-plats-cables-en-nappe	|	PLP	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-ch/c/cables-fils-cables-assembles/cables-plats-cables-en-nappe	|	https://www-ch-ftprdeu.farnell.com/fr-CH/c/cables-fils-cables-assembles/cables-plats-cables-en-nappe	|	PLP	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch/c/cables-fils-cables-assembles/cables-plats-cables-en-nappe	|	https://www-ch-ftprdeu.farnell.com/fr-CH/c/cables-fils-cables-assembles/cables-plats-cables-en-nappe	|	PLP	|
	@eu @PDP
	Examples:
		|	store	|	URLs																																																	|	ExpectedURLs																																													| page|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-BE/lapp-kabel/52006610/bouchon-d-entree-de-cable-m16/dp/1179038	|	https://www-be-ftprdeu.farnell.com/fr-BE/lapp-kabel/52006610/bouchon-d-entree-de-cable-m16/dp/1179038	|	PDP	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-be/lapp-kabel/52006610/bouchon-d-entree-de-cable-m16/dp/1179038	|	https://www-be-ftprdeu.farnell.com/fr-BE/lapp-kabel/52006610/bouchon-d-entree-de-cable-m16/dp/1179038	|	PDP	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be/lapp-kabel/52006610/bouchon-d-entree-de-cable-m16/dp/1179038	|	https://www-be-ftprdeu.farnell.com/fr-BE/lapp-kabel/52006610/bouchon-d-entree-de-cable-m16/dp/1179038	|	PDP	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-CZ/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	https://www-cz-ftprdeu.farnell.com/en-CZ/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	PDP	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-cz/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	https://www-cz-ftprdeu.farnell.com/en-CZ/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	PDP	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/en-cz/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	https://www-cz-ftprdeu.farnell.com/en-CZ/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	PDP	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-DE/tusonix/2499-003-x5w0-103zlf/capacitor-feed-through-10000pf/dp/1186423	|	https://www-de-ftprdeu.farnell.com/en-DE/tusonix/2499-003-x5w0-103zlf/capacitor-feed-through-10000pf/dp/1186423	|	PDP	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-de/tusonix/2499-003-x5w0-103zlf/capacitor-feed-through-10000pf/dp/1186423	|	https://www-de-ftprdeu.farnell.com/en-DE/tusonix/2499-003-x5w0-103zlf/capacitor-feed-through-10000pf/dp/1186423	|	PDP	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/en-de/tusonix/2499-003-x5w0-103zlf/capacitor-feed-through-10000pf/dp/1186423	|	https://www-de-ftprdeu.farnell.com/en-DE/tusonix/2499-003-x5w0-103zlf/capacitor-feed-through-10000pf/dp/1186423	|	PDP	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-IT/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	https://www-it-ftprdeu.farnell.com/en-IT/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	PDP	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-it/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	https://www-it-ftprdeu.farnell.com/en-IT/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	PDP	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	https://www-it-ftprdeu.farnell.com/en-IT/analog-devices/eval-ad5791sdz/evaluation-module-data-converter/dp/2072467	|	PDP	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-CH/belden/9222/cable-9222-triaxial-au-metre/dp/3854723	|	https://www-ch-ftprdeu.farnell.com/fr-CH/belden/9222/cable-9222-triaxial-au-metre/dp/3854723	|	PDP	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-ch/belden/9222/cable-9222-triaxial-au-metre/dp/3854723	|	https://www-ch-ftprdeu.farnell.com/fr-CH/belden/9222/cable-9222-triaxial-au-metre/dp/3854723	|	PDP	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch/belden/9222/cable-9222-triaxial-au-metre/dp/3854723	|	https://www-ch-ftprdeu.farnell.com/fr-CH/belden/9222/cable-9222-triaxial-au-metre/dp/3854723	|	PDP	|
	@eu @mfg
	Examples:
		|	store	|	URLs																								|	ExpectedURLs																				| page							|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-BE/fabricants	|	https://www-be-ftprdeu.farnell.com/fr-BE/fabricants	|	ManufacturerPage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-be/fabricants	|	https://www-be-ftprdeu.farnell.com/fr-BE/fabricants	|	ManufacturerPage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be/fabricants	|	https://www-be-ftprdeu.farnell.com/fr-BE/fabricants	|	ManufacturerPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-CZ/manufacturers	|	https://www-cz-ftprdeu.farnell.com/en-CZ/manufacturers	|	ManufacturerPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-cz/manufacturers	|	https://www-cz-ftprdeu.farnell.com/en-CZ/manufacturers	|	ManufacturerPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/en-cz/manufacturers	|	https://www-cz-ftprdeu.farnell.com/en-CZ/manufacturers	|	ManufacturerPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-DE/manufacturers	|	https://www-de-ftprdeu.farnell.com/en-DE/manufacturers	|	ManufacturerPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-de/manufacturers	|	https://www-de-ftprdeu.farnell.com/en-DE/manufacturers	|	ManufacturerPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/en-de/manufacturers	|	https://www-de-ftprdeu.farnell.com/en-DE/manufacturers	|	ManufacturerPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-IT/manufacturers	|	https://www-it-ftprdeu.farnell.com/en-IT/manufacturers	|	ManufacturerPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-it/manufacturers	|	https://www-it-ftprdeu.farnell.com/en-IT/manufacturers	|	ManufacturerPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it/manufacturers	|	https://www-it-ftprdeu.farnell.com/en-IT/manufacturers	|	ManufacturerPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it/manufacturers	|	https://www-it-ftprdeu.farnell.com/en-IT/manufacturers	|	ManufacturerPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-CH/fabricants	|	https://www-ch-ftprdeu.farnell.com/fr-CH/fabricants	|	ManufacturerPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-ch/fabricants	|	https://www-ch-ftprdeu.farnell.com/fr-CH/fabricants	|	ManufacturerPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch/fabricants	|	https://www-ch-ftprdeu.farnell.com/fr-CH/fabricants	|	ManufacturerPage	|
	@eu @calculator
	Examples:
		|	store	|	URLs																																	|	ExpectedURLs																													| page						|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-BE/calculators-conversion-tools	|	https://www-be-ftprdeu.farnell.com/fr-BE/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/FR-be/calculators-conversion-tools	|	https://www-be-ftprdeu.farnell.com/fr-BE/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-BE	|	https://www-be-ftprdeu.farnell.com/fr-be/calculators-conversion-tools	|	https://www-be-ftprdeu.farnell.com/fr-BE/calculators-conversion-tools	|	CalculatorPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-CZ/calculators-conversion-tools	|	https://www-cz-ftprdeu.farnell.com/en-CZ/calculators-conversion-tools	|	CalculatorPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/EN-cz/calculators-conversion-tools	|	https://www-cz-ftprdeu.farnell.com/en-CZ/calculators-conversion-tools	|	CalculatorPage	|
		|	en-CZ	|	https://www-cz-ftprdeu.farnell.com/en-cz/calculators-conversion-tools	|	https://www-cz-ftprdeu.farnell.com/en-CZ/calculators-conversion-tools	|	CalculatorPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-DE/calculators-conversion-tools	|	https://www-de-ftprdeu.farnell.com/en-DE/calculators-conversion-tools	|	CalculatorPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/EN-de/calculators-conversion-tools	|	https://www-de-ftprdeu.farnell.com/en-DE/calculators-conversion-tools	|	CalculatorPage	|
		|	en-DE	|	https://www-de-ftprdeu.farnell.com/en-de/calculators-conversion-tools	|	https://www-de-ftprdeu.farnell.com/en-DE/calculators-conversion-tools	|	CalculatorPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-IT/calculators-conversion-tools	|	https://www-it-ftprdeu.farnell.com/en-IT/calculators-conversion-tools	|	CalculatorPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/EN-it/calculators-conversion-tools	|	https://www-it-ftprdeu.farnell.com/en-IT/calculators-conversion-tools	|	CalculatorPage	|
		|	en-IT	|	https://www-it-ftprdeu.farnell.com/en-it/calculators-conversion-tools	|	https://www-it-ftprdeu.farnell.com/en-IT/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-CH/calculators-conversion-tools	|	https://www-ch-ftprdeu.farnell.com/fr-CH/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/FR-ch/calculators-conversion-tools	|	https://www-ch-ftprdeu.farnell.com/fr-CH/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-CH	|	https://www-ch-ftprdeu.farnell.com/fr-ch/calculators-conversion-tools	|	https://www-ch-ftprdeu.farnell.com/fr-CH/calculators-conversion-tools	|	CalculatorPage	|
  
  @apac @homepage
	Examples:
		|	store	|	URLs																				|	ExpectedURLs																| page			|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-CN	|	https://www-cn-ftprdap.element14.com/en-CN	|	HomePage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-cn	|	https://www-cn-ftprdap.element14.com/en-CN	|	HomePage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/en-cn	|	https://www-cn-ftprdap.element14.com/en-CN	|	HomePage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-TW	|	https://www-tw-ftprdap.element14.com/en-TW	|	HomePage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-tw	|	https://www-tw-ftprdap.element14.com/en-TW	|	HomePage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/en-tw	|	https://www-tw-ftprdap.element14.com/en-TW	|	HomePage	|
	
	@apac @BFP
	Examples:
		|	store	|	URLs																														|	ExpectedURLs																										| page							|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-CN/browse-for-products	|	https://www-cn-ftprdap.element14.com/en-CN/browse-for-products	|	BrowseForProduct	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-cn/browse-for-products	|	https://www-cn-ftprdap.element14.com/en-CN/browse-for-products	|	BrowseForProduct	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/en-cn/browse-for-products	|	https://www-cn-ftprdap.element14.com/en-CN/browse-for-products	|	BrowseForProduct	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-TW/browse-for-products	|	https://www-tw-ftprdap.element14.com/en-TW/browse-for-products	|	BrowseForProduct	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-tw/browse-for-products	|	https://www-tw-ftprdap.element14.com/en-TW/browse-for-products	|	BrowseForProduct	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/en-tw/browse-for-products	|	https://www-tw-ftprdap.element14.com/en-TW/browse-for-products	|	BrowseForProduct	|
	
	@apac @categorypage
	Examples:
		|	store	|	URLs																																										|	ExpectedURLs																																						| page					|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-CN/c/semiconductors-ics/data-signal-conversion	|	https://www-cn-ftprdap.element14.com/en-CN/c/semiconductors-ics/data-signal-conversion	|	CategoryPage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-cn/c/semiconductors-ics/data-signal-conversion	|	https://www-cn-ftprdap.element14.com/en-CN/c/semiconductors-ics/data-signal-conversion	|	CategoryPage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/en-cn/c/semiconductors-ics/data-signal-conversion	|	https://www-cn-ftprdap.element14.com/en-CN/c/semiconductors-ics/data-signal-conversion	|	CategoryPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-TW/c/semiconductors-ics/data-signal-conversion	|	https://www-tw-ftprdap.element14.com/en-TW/c/semiconductors-ics/data-signal-conversion	|	CategoryPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-tw/c/semiconductors-ics/data-signal-conversion	|	https://www-tw-ftprdap.element14.com/en-TW/c/semiconductors-ics/data-signal-conversion	|	CategoryPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/en-tw/c/semiconductors-ics/data-signal-conversion	|	https://www-tw-ftprdap.element14.com/en-TW/c/semiconductors-ics/data-signal-conversion	|	CategoryPage	|
	
	@apac @PLP
	Examples:
		|	store	|	URLs																																				|	ExpectedURLs																																| page|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-CN/c/electrical/power-outlet-strips	|	https://www-cn-ftprdap.element14.com/en-CN/c/electrical/power-outlet-strips	|	PLP	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-cn/c/electrical/power-outlet-strips	|	https://www-cn-ftprdap.element14.com/en-CN//c/electrical/power-outlet-strips	|	PLP	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/en-cn/c/electrical/power-outlet-strips	|	https://www-cn-ftprdap.element14.com/en-CN/c/electrical/power-outlet-strips	|	PLP	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-TW/c/electrical/accessories-miscellaneous	|	https://www-tw-ftprdap.element14.com/en-TW/c/electrical/accessories-miscellaneous	|	PLP	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-tw/c/electrical/accessories-miscellaneous	|	https://www-tw-ftprdap.element14.com/en-TW/c/electrical/accessories-miscellaneous	|	PLP	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/en-tw/c/electrical/accessories-miscellaneous	|	https://www-tw-ftprdap.element14.com/en-TW/c/electrical/accessories-miscellaneous	|	PLP	|
	
	@apac @PDP
	Examples:
		|	store	|	URLs																																																		|	ExpectedURLs																																														| page|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-CN/multicomp/spc21175/pull-chain-switch-spst-6a-125v/dp/2543085	|	https://www-cn-ftprdap.element14.com/en-CN/multicomp/spc21175/pull-chain-switch-spst-6a-125v/dp/2543085	|	PDP	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-cn/multicomp/spc21175/pull-chain-switch-spst-6a-125v/dp/2543085	|	https://www-cn-ftprdap.element14.com/en-CN/multicomp/spc21175/pull-chain-switch-spst-6a-125v/dp/2543085	|	PDP	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/en-cn/multicomp/spc21175/pull-chain-switch-spst-6a-125v/dp/2543085	|	https://www-cn-ftprdap.element14.com/en-CN/multicomp/spc21175/pull-chain-switch-spst-6a-125v/dp/2543085	|	PDP	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-TW/herga/6311-ble-002/wireless-receiver-bluetooth-2/dp/2822788	|	https://www-tw-ftprdap.element14.com/en-TW/herga/6311-ble-002/wireless-receiver-bluetooth-2/dp/2822788	|	PDP	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-tw/herga/6311-ble-002/wireless-receiver-bluetooth-2/dp/2822788	|	https://www-tw-ftprdap.element14.com/en-TW/herga/6311-ble-002/wireless-receiver-bluetooth-2/dp/2822788	|	PDP	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/en-tw/herga/6311-ble-002/wireless-receiver-bluetooth-2/dp/2822788	|	https://www-tw-ftprdap.element14.com/en-TW/herga/6311-ble-002/wireless-receiver-bluetooth-2/dp/2822788	|	PDP	|
		
	@apac @mfg
	Examples:
		|	store	|	URLs																											|	ExpectedURLs																							| page							|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-CN/manufacturers	|	https://www-cn-ftprdap.element14.com/en-CN/manufacturers	|	ManufacturerPage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-cn/manufacturers	|	https://www-cn-ftprdap.element14.com/en-CN/manufacturers	|	ManufacturerPage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/en-cn/manufacturers	|	https://www-cn-ftprdap.element14.com/en-CN/manufacturers	|	ManufacturerPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-TW/manufacturers	|	https://www-tw-ftprdap.element14.com/en-TW/manufacturers	|	ManufacturerPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-tw/manufacturers	|	https://www-tw-ftprdap.element14.com/en-TW/manufacturers	|	ManufacturerPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/en-tw/manufacturers	|	https://www-tw-ftprdap.element14.com/en-TW/manufacturers	|	ManufacturerPage	|
		
	@apac @calculator
	Examples:
		|	store	|	URLs																																		|	ExpectedURLs																														| page						|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-CN/calculators-conversion-tools	|	https://www-cn-ftprdap.element14.com/en-CN/calculators-conversion-tools	|	CalculatorPage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/EN-cn/calculators-conversion-tools	|	https://www-cn-ftprdap.element14.com/en-CN/calculators-conversion-tools	|	CalculatorPage	|
		| en-CN	|	https://www-cn-ftprdap.element14.com/en-cn/calculators-conversion-tools	|	https://www-cn-ftprdap.element14.com/en-CN/calculators-conversion-tools	|	CalculatorPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-TW/calculators-conversion-tools	|	https://www-tw-ftprdap.element14.com/en-TW/calculators-conversion-tools	|	CalculatorPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/EN-tw/calculators-conversion-tools	|	https://www-tw-ftprdap.element14.com/en-TW/calculators-conversion-tools	|	CalculatorPage	|
		| en-TW	|	https://www-tw-ftprdap.element14.com/en-tw/calculators-conversion-tools	|	https://www-tw-ftprdap.element14.com/en-TW/calculators-conversion-tools	|	CalculatorPage	|
	
	@nwk @homepage
	Examples:
		|	store	|	URLs																	|	ExpectedURLs													| page			|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-BR	|	https://www-ftprdus.newark.com/pt-BR	|	HomePage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-br	|	https://www-ftprdus.newark.com/pt-BR	|	HomePage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/pt-br	|	https://www-ftprdus.newark.com/pt-BR	|	HomePage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-CA	|	https://www-canada-ftprdus.newark.com/fr-CA	|	HomePage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-ca	|	https://www-canada-ftprdus.newark.com/fr-CA	|	HomePage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/fr-ca	|	https://www-canada-ftprdus.newark.com/fr-CA	|	HomePage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-MX	|	https://www-mexico-ftprdus.newark.com/en-MX	|	HomePage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-mx	|	https://www-mexico-ftprdus.newark.com/en-MX	|	HomePage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/en-mx	|	https://www-mexico-ftprdus.newark.com/en-MX	|	HomePage	|
		|	es-US	|	https://www-ftprdus.newark.com/ES	|	https://www-ftprdus.newark.com/es	|	HomePage	|
	
	@nwk @BFP
	Examples:
		|	store	|	URLs																											|	ExpectedURLs																							| page							|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-BR/browse-for-products	|	https://www-ftprdus.newark.com/pt-BR/browse-for-products	|	BrowserForProduct	|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-br/browse-for-products	|	https://www-ftprdus.newark.com/pt-BR/browse-for-products	|	BrowserForProduct	|
		|	pt-BR	|	https://www-ftprdus.newark.com/pt-br/browse-for-products	|	https://www-ftprdus.newark.com/pt-BR/browse-for-products	|	BrowserForProduct	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-MX/browse-for-products	|	https://www-mexico-ftprdus.newark.com/en-MX/browse-for-products	|	BrowserForProduct	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-mx/browse-for-products	|	https://www-mexico-ftprdus.newark.com/en-MX/browse-for-products	|	BrowserForProduct	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/en-mx/browse-for-products	|	https://www-mexico-ftprdus.newark.com/en-MX/browse-for-products	|	BrowserForProduct	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-CA/rechercher-des-produits	|	https://www-canada-ftprdus.newark.com/fr-CA/rechercher-des-produits	|	BrowserForProduct	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-ca/rechercher-des-produits	|	https://www-canada-ftprdus.newark.com/fr-CA/rechercher-des-produits	|	BrowserForProduct	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/fr-ca/rechercher-des-produits	|	https://www-canada-ftprdus.newark.com/fr-CA/rechercher-des-produits	|	BrowserForProduct	|
		|	es-US	|	https://www-ftprdus.newark.com/ES/browse-for-products	|	https://www-ftprdus.newark.com/es/browse-for-products	|	BrowserForProduct	|
		
	@nwk @categorypage
	Examples:
		|	store	|	URLs																																								|	ExpectedURLs																																				| page					|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-BR/c/semiconductors-ics/power-management-ics-pmic	|	https://www-ftprdus.newark.com/pt-BR/c/semiconductors-ics/power-management-ics-pmic	|	CategoryPage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-br/c/semiconductors-ics/power-management-ics-pmic	|	https://www-ftprdus.newark.com/pt-BR/c/semiconductors-ics/power-management-ics-pmic	|	CategoryPage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/pt-br/c/semiconductors-ics/power-management-ics-pmic	|	https://www-ftprdus.newark.com/pt-BR/c/semiconductors-ics/power-management-ics-pmic	|	CategoryPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-CA/c/connectors/circular-connectors-components	|	https://www-canada-ftprdus.newark.com/fr-CA/c/connectors/circular-connectors-components	|	CategoryPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-ca/c/connectors/circular-connectors-components	|	https://www-canada-ftprdus.newark.com/fr-CA/c/connectors/circular-connectors-components	|	CategoryPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/fr-ca/c/connectors/circular-connectors-components	|	https://www-canada-ftprdus.newark.com/fr-CA/c/connectors/circular-connectors-components	|	CategoryPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-MX/c/semiconductors-discretes/diodes	|	https://www-mexico-ftprdus.newark.com/en-MX/c/semiconductors-discretes/diodes	|	CategoryPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-mx/c/semiconductors-discretes/diodes	|	https://www-mexico-ftprdus.newark.com/en-MX/c/semiconductors-discretes/diodes	|	CategoryPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/en-mx/c/semiconductors-discretes/diodes	|	https://www-mexico-ftprdus.newark.com/en-MX/c/semiconductors-discretes/diodes	|	CategoryPage	|
		|	es-US	|	https://www-ftprdus.newark.com/ES/c/semiconductores-discretos/transistores	|	https://www-ftprdus.newark.com/es/c/semiconductores-discretos/transistores	|	CategoryPage	|
		
	@nwk @PLP
	Examples:
		|	store	|	URLs																															|	ExpectedURLs																											| page|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-BR/c/electrical/more-electrical	|	https://www-ftprdus.newark.com/pt-BR/c/electrical/more-electrical	|	PLP	|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-br/c/electrical/more-electrical	|	https://www-ftprdus.newark.com/pt-BR/c/electrical/more-electrical	|	PLP	|
		|	pt-BR	|	https://www-ftprdus.newark.com/pt-br/c/electrical/more-electrical	|	https://www-ftprdus.newark.com/pt-BR/c/electrical/more-electrical	|	PLP	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-CA/c/electrical/accessories-miscellaneous	|	https://www-canada-ftprdus.newark.com/fr-CA/c/electrical/accessories-miscellaneous	|	PLP	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-ca/c/electrical/accessories-miscellaneous	|	https://www-canada-ftprdus.newark.com/fr-CA/c/electrical/accessories-miscellaneous	|	PLP	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/fr-ca/c/electrical/accessories-miscellaneous	|	https://www-canada-ftprdus.newark.com/fr-CA/c/electrical/accessories-miscellaneous	|	PLP	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-MX/c/electrical/switch-socket-ranges	|	https://www-mexico-ftprdus.newark.com/en-MX/c/electrical/switch-socket-ranges	|	PLP	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-mx/c/electrical/switch-socket-ranges	|	https://www-mexico-ftprdus.newark.com/en-MX/c/electrical/switch-socket-ranges	|	PLP	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/en-mx/c/electrical/switch-socket-ranges	|	https://www-mexico-ftprdus.newark.com/en-MX/c/electrical/switch-socket-ranges	|	PLP	|
		|	es-US	|	https://www-ftprdus.newark.com/ES/c/fijaciones-mecanicas/engranajes	|	https://www-ftprdus.newark.com/es/c/fijaciones-mecanicas/engranajes	|	PLP	|
		
	@nwk @PDP
	Examples:
		|	store	|	URLs																																																|	ExpectedURLs																																												| page|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-BR/amp-te-connectivity/1544425-2/frame-lead-sil-2-54mm/dp/28T0237	|	https://www-ftprdus.newark.com/pt-BR/amp-te-connectivity/1544425-2/frame-lead-sil-2-54mm/dp/28T0237	|	PDP	|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-br/amp-te-connectivity/1544425-2/frame-lead-sil-2-54mm/dp/28T0237	|	https://www-ftprdus.newark.com/pt-BR/amp-te-connectivity/1544425-2/frame-lead-sil-2-54mm/dp/28T0237	|	PDP	|
		|	pt-BR	|	https://www-ftprdus.newark.com/pt-br/amp-te-connectivity/1544425-2/frame-lead-sil-2-54mm/dp/28T0237	|	https://www-ftprdus.newark.com/pt-BR/amp-te-connectivity/1544425-2/frame-lead-sil-2-54mm/dp/28T0237	|	PDP	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-CA/lg/aed73593202/handle-assembly-refrigerator/dp/06X4802	|	https://www-canada-ftprdus.newark.com/fr-CA/lg/aed73593202/handle-assembly-refrigerator/dp/06X4802	|	PDP	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-ca/lg/aed73593202/handle-assembly-refrigerator/dp/06X4802	|	https://www-canada-ftprdus.newark.com/fr-CA/lg/aed73593202/handle-assembly-refrigerator/dp/06X4802	|	PDP	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/fr-ca/lg/aed73593202/handle-assembly-refrigerator/dp/06X4802	|	https://www-canada-ftprdus.newark.com/fr-CA/lg/aed73593202/handle-assembly-refrigerator/dp/06X4802	|	PDP	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-MX/belden/ax101456/flex-patch-panel-24port-1u/dp/28W2492	|	https://www-mexico-ftprdus.newark.com/en-MX/belden/ax101456/flex-patch-panel-24port-1u/dp/28W2492	|	PDP	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-mx/belden/ax101456/flex-patch-panel-24port-1u/dp/28W2492	|	https://www-mexico-ftprdus.newark.com/en-MX/belden/ax101456/flex-patch-panel-24port-1u/dp/28W2492	|	PDP	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/en-mx/belden/ax101456/flex-patch-panel-24port-1u/dp/28W2492	|	https://www-mexico-ftprdus.newark.com/en-MX/belden/ax101456/flex-patch-panel-24port-1u/dp/28W2492	|	PDP	|
		|	es-US	|	https://www-ftprdus.newark.com/ES/hammond-power-solutions/rm0045p70/current-transformer/dp/31C9470	|	https://www-ftprdus.newark.com/es/hammond-power-solutions/rm0045p70/current-transformer/dp/31C9470	|	PDP	|
	
	@nwk @mfg
	Examples:
		|	store	|	URLs																								|	ExpectedURLs																				| page							|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-BR/manufacturers	|	https://www-ftprdus.newark.com/pt-BR/manufacturers	|	ManufacturerPage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-br/manufacturers	|	https://www-ftprdus.newark.com/pt-BR/manufacturers	|	ManufacturerPage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/pt-br/manufacturers	|	https://www-ftprdus.newark.com/pt-BR/manufacturers	|	ManufacturerPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-CA/rechercher-des-produits	|	https://www-canada-ftprdus.newark.com/fr-CA/rechercher-des-produits	|	ManufacturerPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-ca/rechercher-des-produits	|	https://www-canada-ftprdus.newark.com/fr-CA/rechercher-des-produits	|	ManufacturerPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/fr-ca/rechercher-des-produits	|	https://www-canada-ftprdus.newark.com/fr-CA/rechercher-des-produits	|	ManufacturerPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-MX/manufacturers	|	https://www-mexico-ftprdus.newark.com/en-MX/manufacturers	|	ManufacturerPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-mx/manufacturers	|	https://www-mexico-ftprdus.newark.com/en-MX/manufacturers	|	ManufacturerPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/en-mx/manufacturers	|	https://www-mexico-ftprdus.newark.com/en-MX/manufacturers	|	ManufacturerPage	|
		|	es-US	|	https://www-ftprdus.newark.com/ES/fabricantes	|	https://www-ftprdus.newark.com/es/fabricantes	|	ManufacturerPage	|
	
	@nwk @calculator
	Examples:
		|	store	|	URLs																															|	ExpectedURLs																											| page						|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-BR/calculators-conversion-tools	|	https://www-ftprdus.newark.com/pt-BR/calculators-conversion-tools	|	CalculatorPage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/PT-br/calculators-conversion-tools	|	https://www-ftprdus.newark.com/pt-BR/calculators-conversion-tools	|	CalculatorPage	|
		|	pt-BR	|	https://www-ftprdus.newark.com/pt-br/calculators-conversion-tools	|	https://www-ftprdus.newark.com/pt-BR/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-CA/calculators-conversion-tools	|	https://www-canada-ftprdus.newark.com/fr-CA/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/FR-ca/calculators-conversion-tools	|	https://www-canada-ftprdus.newark.com/fr-CA/calculators-conversion-tools	|	CalculatorPage	|
		|	fr-CA	|	https://www-canada-ftprdus.newark.com/fr-ca/calculators-conversion-tools	|	https://www-canada-ftprdus.newark.com/fr-CA/calculators-conversion-tools	|	CalculatorPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-MX/calculators-conversion-tools	|	https://www-mexico-ftprdus.newark.com/en-MX/calculators-conversion-tools	|	CalculatorPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/EN-mx/calculators-conversion-tools	|	https://www-mexico-ftprdus.newark.com/en-MX/calculators-conversion-tools	|	CalculatorPage	|
		|	en-MX	|	https://www-mexico-ftprdus.newark.com/en-mx/calculators-conversion-tools	|	https://www-mexico-ftprdus.newark.com/en-MX/calculators-conversion-tools	|	CalculatorPage	|
		|	es-US	|	https://www-ftprdus.newark.com/ES/calculators-conversion-tools	|	https://www-ftprdus.newark.com/es/calculators-conversion-tools	|	CalculatorPage	|